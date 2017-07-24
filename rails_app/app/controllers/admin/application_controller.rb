# All Administrate controllers inherit from this `Admin::ApplicationController`,
# making it the ideal place to put authentication logic or other
# before_filters.
#
# If you want to add pagination or other controller-level concerns,
# you're free to overwrite the RESTful controller actions.
module Admin
  class ApplicationController < Administrate::ApplicationController
    before_action :admin_only


    def admin_only
      unless current_user && (current_user.admin? || current_user.super?)
        redirect_to :back, :alert => "Access denied."
      end
    end

    def super_only
      unless current_user && current_user.super?
        redirect_to :back, :alert => "Access denied."
      end
    end


    # Override this value to specify the number of elements to display at a time
    # on index pages. Defaults to 20.
    # def records_per_page
    #   params[:per_page] || 20
    # end
  end
end
