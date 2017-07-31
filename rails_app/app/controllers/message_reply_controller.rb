class MessageReplyController < ApplicationController

  layout "message_reply"

  def index
    puts "===== iii"
    @message_replys = MessageReply.order(message_id: :desc)
  end

  def create
    @message_reply = MessageReply.new(message_reply_params)

    if @message_reply.save
          redirect_to message_reply_index_path
    else
      render index
    end
  end

  def edit
    @message_replys = MessageReply.find(params[:id])
  end

  def update
    @message_reply = MessageReply.find(params[:id])

    if @message_reply.update_attributes(message_reply_params)
      flash[:success] = "Message reply updated"
      redirect_to edit_message_reply_path(:id => @message_reply)
    else
      rendor :edit
    end
  end

  def show
    @messageReply = MessageReply.find(params[:id])
    #@messageReply.payload
  end

  def destroy
    @messageReply = MessageReply.find(params[:id])
    @messageReply.destroy

    redirect_to message_reply_index_path
  end

  private

  #def same_vendor
  # current_user.vendor_id
  #end

  def message_reply_params
    params.require(:message_reply).permit(:description, :message_text, :message_id)
  end

  def flashes

  end

end