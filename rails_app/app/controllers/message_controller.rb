class MessageController < ApplicationController

  layout "message"

  def index
    puts "===== iii"
    @messages = Message.order(name: :asc)
  end

  def show
    @message = Message.find(params[:id])
    @message.payload
  end

  def edit
    @message = Message.find(params[:id])
  end

  def update
    @message = Message.find(params[:id])

    if @message.update_attributes(message_params)
      flash[:success] = "Message updated"
      redirect_to edit_message_path(:id => @message.message_id)
    else
      rendor :edit
    end
  end

  def destroy
    @message = Message.find(params[:id])
    @message.destroy

    redirect_to message_index_path
  end


  private

  #def same_vendor
  # current_user.vendor_id
  #end

  def message_params
    params.require(:message).permit(:name, :package_group, :default_message_txt, :message_reply_id, :xsd_file, :root_element)
  end

  def flashes

  end

end
