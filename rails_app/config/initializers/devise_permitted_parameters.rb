module DevisePermittedParameters
  extend ActiveSupport::Concern

  included do
    before_action :configure_permitted_parameters
  end

  protected

  def configure_permitted_parameters
    devise_parameter_sanitizer.for(:sign_up) << [:name, :vendor_id]
    devise_parameter_sanitizer.for(:account_update) << :name
  end

end

DeviseController.send :include, DevisePermittedParameters
