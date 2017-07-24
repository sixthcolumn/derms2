class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception

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

  def admin?
    current_user && ( current_user.admin? || current_user.super?)
  end

  def super?
    current_user && current_user.super?
  end

end
