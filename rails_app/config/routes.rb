Rails.application.routes.draw do
	namespace :admin do
		resources :users
		root to: "users#index"
	end

	#root to: 'visitors#index'

	devise_for :users
	resources :users
	resources :vendors
	resources :test_sequence
	resources :message_log
	resources :vendor_test_sequence
	resources :vendor_test_seq_step
	resources :message_log
	resources :request_log

	get 'vendor_request_message/:id/sendRequest' => 'vendor_request_message#sendRequest', as: 'sendRequest_vendor_request_message'
	get 'vendor_request_message/results' => 'vendor_request_message#results'
	resources :vendor_request_message


	get 'test_seq_step/packages' => 'test_seq_step#packages'
	resources :test_seq_step   #, :except => ['new']
	get 'test_seq_step/new/:id' => 'test_seq_step#new', as: 'new_test_seq_step2'

	get "home/index" => 'home'

	root to: 'home#splash'
end
