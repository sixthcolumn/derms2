class TestSequence < ActiveRecord::Base
	self.table_name = 'test_sequence'
	self.primary_key = :test_sequence_id
	self.inheritance_column = :ruby_type
	has_many :test_seq_step, :dependent => :destroy, :class_name => 'TestSeqStep', :foreign_key => :test_sequence_id
	has_many :vendor_test_sequence, :dependent => :destroy, :class_name => 'VendorTestSequence'
	belongs_to :user, :class_name => 'User', :foreign_key => :user_id

	def user_name
		try(:user).try(:name).presence || 'None'
	end
end
