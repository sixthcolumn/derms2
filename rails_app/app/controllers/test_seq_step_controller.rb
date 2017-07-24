class TestSeqStepController < ApplicationController

	layout "test_seq_step"

	def index
	end
	def edit
		@step = TestSeqStep.find(params[:id])
		@pkg = Package.all
	end

	def new
		@test_sequence_id = params[:id]
	end

	def packages
		a = my_packages.map{|s| {
			text: s.name,
			nodes: s.package_group.map{ |p| {
				text: p.name,
				nodes: p.messages.map{ |m| {text: m.name, id: m.message_id}}
			}}
		}}

		render json: a.to_json
	end

	def destroy
		@step = TestSeqStep.find(params[:id])
		@step.destroy

		redirect_to edit_test_sequence_path(:id => @step.test_sequence_id)
	end



	def show
		#@step = TestSeqStep.find(params[:id])
		#@pkg = my_packages
		redirect_to edit_test_sequence_path(:id => @step.test_sequence_id)
	end

	def create
		@step = TestSeqStep.new(step_params)
		@step.next_step_id = nil


		if @step.save
			redirect_to edit_test_sequence_path(:id => @step.test_sequence_id)
		else
			render index
		end
	end

	def update
		@step = TestSeqStep.find(params[:id])

		if @step.update_attributes(step_params)
			flash[:success] = "Test Sequence Step updated"
			redirect_to edit_test_sequence_path(:id => @step.test_sequence_id)
		else
			rendor :edit
		end
	end


	private

	def my_packages
		return Package.joins(:vendors).where(vendor_id = same_vendor)
	end

	def same_vendor
		current_user.vendor_id
	end

	def step_params
		params.require(:test_seq_step).permit(:in_message_id, :esb_url, :harness_url, :swap_corrid_flag, :test_sequence_id, :next_step_id)
	end

end
