class MessageLog < ActiveRecord::Base
	self.table_name = 'message_log'
	self.primary_key = :message_log_id
	belongs_to :message, :class_name => 'Message', :foreign_key => :message_id

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

	def vid
		select_value(
		%Q[
			select vendor_packages.vendor_id
			from vendor_packages,
			message,
			package_group,
			package
			where  message_id = 10
			and package_group.package_group_id = message.package_group_id
			and package.package_id = package_group.package_id
			and vendor_packages.package_id = package_group.package_id
		]
		)
	end

	def is_cool?
		return true
	end

end
