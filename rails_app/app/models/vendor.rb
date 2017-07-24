class Vendor < ActiveRecord::Base
	self.table_name = 'vendor'
	self.primary_key = :vendor_id
	has_and_belongs_to_many :packages, join_table: "vendor_packages", :foreign_key => :vendor_id
	has_many :users, :class_name => 'User'

	validates :name, presence: true,
	length: { minimum: 4 }
end
