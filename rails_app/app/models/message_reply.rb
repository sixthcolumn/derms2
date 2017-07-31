class MessageReply < ActiveRecord::Base
    self.table_name = 'message_reply'
    self.primary_key = :message_reply_id
	belongs_to :message, :class_name => 'Message', :foreign_key => :message_id
end