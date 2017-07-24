class VendorTestSequenceController < ApplicationController

	layout "vendor_test_sequence"

	def index
		@tests = VendorTestSequence.where(vendor_id: same_vendor)
	end

	def create
		@test = VendorTestSequence.new(test_params)
		@test.vendor_id = same_vendor

		if @test.save
			@test.test_sequence.test_seq_step.each do |step|
				@vstep = VendorTestSeqStep.new(vendor_test_sequences_id: @test.vendor_test_sequences_id,
				test_seq_step_id: step.test_seq_step_id,
				out_url: params[:vendor_test_sequence][:vendor_url])
				@vstep.save
			end
			flash[:success] = "Vendor Test Sequence created"
			redirect_to vendor_test_sequence_index_path
		else
			flash[:success] = "Error saving Vendor Test Sequence"
			render vendor_test_sequence_index_path
		end
	end

	def update
		@test = VendorTestSequence.find(params[:id])

		if @test.update_attributes(test_params)
			#@test.vendor_test_seq_steps.each do |step|
			#	step.out_url = params[:vendor_test_sequence][:vendor_url]
			#	step.save
			#end
			flash[:success] = "Vendor Test Sequence updated"
			redirect_to vendor_test_sequence_index_path
		else
			rendor :edit
		end
	end

	def edit
		@test = VendorTestSequence.find(params[:id])
		@user = current_user
		if @test.vendor_test_seq_steps.present?
			@vendor_url = @test.vendor_test_seq_steps.first.out_url
		else
			@vendor_url = ''
		end
	end

	def destroy
		@test = VendorTestSequence.find(params[:id])
		@test.destroy

		redirect_to vendor_test_sequence_index_path
	end

	def show
		@ts = VendorTestSequence.find(params[:id])
	end

	private

	def test_params
		params.require(:vendor_test_sequence).permit(:asynch_flag, :test_sequence_id, :user_id, :comment)
	end

	def flashes

	end

	def same_vendor
		current_user.vendor_id
	end

end
