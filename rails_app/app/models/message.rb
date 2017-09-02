class Message < ActiveRecord::Base
    self.table_name = 'message'
    self.primary_key = :message_id

    belongs_to :package_group, :class_name => 'PackageGroup', :foreign_key => :package_group_id
    belongs_to :selected_message, :class_name => 'MessageReply', :foreign_key => :message_reply_id
    accepts_nested_attributes_for :selected_message
    has_many :message_logs, :class_name => 'MessageLog', :foreign_key => :message_id
    has_many :test_seq_steps, :class_name => 'TestSeqStep'
    has_many :vendor_request_messages, :class_name => 'VendorRequestMessage', :foreign_key => :message_id
    has_many :message_reply, :class_name => 'MessageReply', :foreign_key => :message_id
end
