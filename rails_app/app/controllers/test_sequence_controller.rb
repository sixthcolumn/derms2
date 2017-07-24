class TestSequenceController < ApplicationController

	layout "test_sequence"

	def index
		puts "===== iii"
		#@tests = TestSequence.joins(:vendor_test_sequence).where(vendor_test_sequences: { vendor_id: same_vendor})
		@tests = TestSequence.all

	end

	def create
		@test = TestSequence.new(test_params)
		@test.user = current_user

		if @test.save
			#@test.vendor_test_sequence.create(:vendor_id => same_vendor, :asynch_flag=> 0)
			redirect_to test_sequence_index_path
		else
			render test_sequence_index_path
		end
	end

	def update
		@test = TestSequence.find(params[:id])

		if @test.update_attributes(test_params)
			flash[:success] = "Test Sequence updated"
			redirect_to test_sequence_index_path
		else
			rendor :edit
		end
	end

	def edit
		@test = TestSequence.find(params[:id])
	end


	def destroy
		@test = TestSequence.find(params[:id])
		@test.destroy

		redirect_to test_sequence_index_path
	end

	def show
		@ts = TestSequence.find(params[:id])
	end


	private

	#def same_vendor
	#	current_user.vendor_id
	#end

	def test_params
		params.require(:test_sequence).permit(:name, :description, :type)
	end

	def flashes

	end


end
