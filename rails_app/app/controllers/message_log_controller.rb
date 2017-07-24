class MessageLogController < ApplicationController

  layout "message_log"

  def index
    puts "===== iii"
    @logs = filter_by_vendor
  end

  def show
    @log = MessageLog.find(params[:id])
    @log.payload
  end

  def destroy
    @log = MessageLog.find(params[:id])
    @log.destroy

    redirect_to message_log_index_path
  end

  private

  def filter_by_vendor
    MessageLog.find_by_sql(
      %Q[
			select message_log.* 
			  from message_log,
			       message,
			       package_group,
			       package,
			       vendor_packages
			 where vendor_packages.vendor_id = #{same_vendor}
			   and package.package_id = vendor_packages.package_id
			   and package_group.package_id = package.package_id
			   and message.package_group_id = package_group.package_group_id
			   and message_log.message_id = message.message_id
         order by message_log.message_log_id desc
		])
  end

  private

  def same_vendor
    current_user.vendor_id
  end
end
