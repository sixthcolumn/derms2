class AddUsertoTestSequence < ActiveRecord::Migration
	def change

		add_reference :test_sequence, :user, index: true, foreign_key: true
		add_foreign_key :test_sequence, :users
	end
end
