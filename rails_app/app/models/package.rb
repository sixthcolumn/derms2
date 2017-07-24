class Package < ActiveRecord::Base
	self.table_name = 'package'
	self.primary_key = :package_id

	has_and_belongs_to_many :vendors, join_table: "vendor_packages", :foreign_key => :package_id
	has_many :package_group, :class_name => 'PackageGroup'
end
