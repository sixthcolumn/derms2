class HomeController < ApplicationController
	before_action :authenticate_user!
	def index
		puts "hit"
		@page_title = "Home"
		# @vendors = VendorRoleType.where("active_flag = 1")
	end

	def splash
		@page_title = "Home"
		render :layout => "splash"
	end
end
