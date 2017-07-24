# Vendor CRUD, forms located under
# app/views/vendors dir
class VendorsController < ApplicationController
	before_action :authenticate_user!
	before_action :super_only

	# user app/views/vendors
	layout "vendors"

	def index
		@vendors = Vendor.all
	end

	def show
		@vendor = Vendor.find(params[:id])
	end


	def edit
		@vendor = Vendor.find(params[:id])
	end

	# todo : modify to allow for package links at create time
	def create
		@vendor = Vendor.new(vendor_params)

		if @vendor.save
			redirect_to @vendor
		else
			render 'new'
		end
	end

	def update
		@vendor = Vendor.find(params[:id])

		# kill all linked vendor_packages, and then recreate
		@vendor.packages.destroy_all
		@vendor.packages << Package.find(params[:vendor][:package_ids].reject { |c| c.empty? })

		if @vendor.update_attributes(vendor_params)
			flash[:success] = "Vendor updated"
			redirect_to vendors_path
		else
			rendor :edit
		end
	end

	def destroy
		@vendor = Vendor.find(params[:id])
		@vendor.destroy

		redirect_to vendors_path
	end



	private

	def vendor_params
		params.require(:vendor).permit(:name, :default_url)
	end

	def flashes

	end
end
