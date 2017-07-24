class AddTestSeqToUser < ActiveRecord::Migration
	def change
		add_column :test_sequence, :user_id, :integer
		#add_foreign_key :test_sequence, :user, column: :user_id
		#add_foreign_key :users, :test_sequence, column: :user_id
	end
end
