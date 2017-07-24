class VendorTestSeqStepController < ApplicationController

	layout "vendor_test_seq_step"

	def index
	end
	def edit
		@step = VendorTestSeqStep.find(params[:id])
	end

	def new
		@vendor_test_sequence_id = params[:id]
	end

	def destroy
		@step = VendorTestSeqStep.find(params[:id])
		@step.destroy

		redirect_to edit_vendor_test_sequence_path(:id => @step.test_sequence_id)
	end

	def show
		#@step = TestSeqStep.find(params[:id])
		#@pkg = my_packages
		redirect_to edit_vendor_test_sequence_path(:id => @step.vendor_test_sequence_id)
	end

	def create
		@step = VendorTestSeqStep.new(step_params)
		@step.next_step_id = nil


		if @step.save
			redirect_to edit_vendor_test_sequence_path(:id => @step.test_sequence_id)
		else
			render index
		end
	end

	def update
		@step = VendorTestSeqStep.find(params[:id])
		if @step.update_attributes(step_params)
			flash[:success] = "Vendor Test Sequence Step updated"
			redirect_to edit_vendor_test_sequence_path(:id => @step.vendor_test_sequences_id)
		else
			rendor :edit
		end
	end


	private


	def same_vendor
		current_user.vendor_id
	end

	def step_params
		params.require(:vendor_test_seq_step).permit(:out_url)
	end
end
