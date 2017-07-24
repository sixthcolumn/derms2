class RequestLog < ActiveRecord::Base
	self.table_name = 'request_log'
	self.primary_key = :request_log_id

=begin
	def vendor_id
		Vendor.find_by_sql(
			"select vendor_packages.vendor_id as vendor_id
			   from message, package_group, package, vendor_packages
			  where message.message_id = '#{self.message_id}'
			    and package_group.package_group_id = message.package_group_id
			    and package.package_id = package_group.package_id
			    and vendor_packages.package_id = package.package_id limi 1
			")
	end
=end

end
