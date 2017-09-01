class HomeController < ApplicationController
	before_action :authenticate_user!
	def index
		@page_title = "Home"
		# @vendors = VendorRoleType.where("active_flag = 1")
	end

	def help
		#@page_title = "Help"
	end

	def download_soapui
		send_file(
			"#{Rails.root}/public/soap-ui.zip",
			filename: "soap-ui.zip",
			type: "application/zip"
		)
	end

	def splash
		@page_title = "Home"
		render :layout => "splash"
	end
end
