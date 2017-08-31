class VendorRequestMessageController < ApplicationController

  layout "vendor_request_message"

  require "rexml/document"
  require 'ostruct'

  def index
    @messages = VendorRequestMessage.where(vendor_id: same_vendor)
  end

  def create
    @message = VendorRequestMessage.new(test_params)
    @message.vendor_id = same_vendor

    if @message.save
      sendMessage()
    else
      render index
    end
  end

  def destroy
    @msg = VendorRequestMessage.find(params[:id])
    @msg.destroy

    redirect_to vendor_request_message_index_path
  end

  def results
    @message = VendorRequestMessage.find(params[:id])
    render :results
  end

  def show
    @ts = VendorRequestMessage.find(params[:id])
    render :results
  end

  def update
    puts "======== update called"
    @message = VendorRequestMessage.find(params[:id])

    cmd = params[:commit]

    if cmd == "Send"
      sendMessage()
    else
      @message.update_attributes(test_params)
      render :edit
    end
  end

  def edit
    @page_title = 'Edit Request Message'
    @message = VendorRequestMessage.find(params[:id])
  end

  def sendRequest
    @message = VendorRequestMessage.find(params[:id])
    sendMessage
  end



  private

  def validate(xml,schema_path,root, response)
    puts "xml : #{xml}"
    puts "schema_path : #{schema_path}"
    puts "root : #{root}"

    # open schema file, and create doc from xml string
    xsd = Nokogiri::XML::Schema(File.open(schema_path))
    doc = Nokogiri::XML(xml)

    frag = doc.xpath(root)

    puts "frag : #{frag}"

    # create new document of with just the payload
    doc2 = Nokogiri::XML(frag.to_s);

    # add NS from soap envelope to the new doc
    doc.collect_namespaces.each do |key, value|
      puts "key : #{key}, value : #{value}"
      doc2.root.add_namespace_definition(key.sub(/^xmlns:/,''),value)
    end

    puts "doc2 : #{doc2}"

    # for some reason, the doc2 is not validate-able
    # so create new doc from it, which is parse-able
    doc3 = Nokogiri::XML(doc2.to_s)

    puts "doc3 : #{doc3}"

    rc = xsd.valid?(doc3)
    if ! rc
      response.xml_validation_errors = ''
      response.flash_error_message = 'XML Validation failed'
      xsd.validate(doc3).each do |error|
        puts error.message
        response.xml_validation_errors += error.message
      end
    end

    return rc

  end

  def sendMessage

    @response = OpenStruct.new
    @response.message = @message.message_txt


    if validate(@message.message_txt, Rails.root + @message.message.xsd_file, '//*[local-name() = \'' + @message.message.root_element + '\']', @response)
      uri = URI.parse @message.sent_to_url

      http = Net::HTTP.new(uri.host, uri.port)

      req = Net::HTTP::Post.new(uri.request_uri)
      req.body = @message.message_txt
      req.content_type = 'text/xml'

      reply = Net::HTTP.new(uri.host, uri.port).start { |http| http.request req}


      @response.code = reply.code
      @response.body = reply.body

      @page_title = 'Results'

      render :results
    else
      @response.code = 'Message not sent'
      flash[:error] = @response.flash_error_message
      render :results

    end
  rescue => e
    puts "rescue"
    flash.now[:error] = "Request failed : " + e.message
    @response.code = "No Results"
    @response.body = "No Results"
    render :results
  end


  def same_vendor
    current_user.vendor_id
  end

  def test_params
    params.require(:vendor_request_message).permit(:message_id, :message_txt, :description, :sent_to_url)
  end

  def flashes

  end


end
