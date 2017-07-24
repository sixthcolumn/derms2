class User < ActiveRecord::Base
	enum role: [:user, :vip, :admin, :super]
	after_initialize :set_default_role, :if => :new_record?

	def set_default_role
		self.role ||= :user
	end

	# Include default devise modules. Others available are:
	# :confirmable, :lockable, :timeoutable and :omniauthable
	devise :database_authenticatable, :registerable,
	:recoverable, :rememberable, :trackable, :validatable

	belongs_to :vendor, :class_name => 'Vendor', :foreign_key => :vendor_id
	has_many :test_sequences, :class_name => 'TestSequence'
end
