class UsersController < ApplicationController
  before_action :authenticate_user!
  before_action :admin_only, :except => :show

  # Override DEVISE, and disable everything. All user
  # methods are run through administrate
  # routes.rb : devise_for :users

  def index
    puts "====== index users"
    #@users = User.all
    redirect_to :back, :alert => "Access denied."
  end

  def show
    @user = User.find(params[:id])
    unless current_user.admin?
      unless @user == current_user
        redirect_to :back, :alert => "Access denied."
      end
    end
  end

  def new
    puts "======== new"
    redirect_to :back, :alert => "Access denied."
  end

  def edit
    puts "======= edit"
    redirect_to :back, :alert => "Access denied."
  end

  def update
    puts "======= update"
    redirect_to :back, :alert => "Access denied."
    @user = User.find(params[:id])
    if @user.update_attributes(secure_params)
      redirect_to users_path, :notice => "User updated."
    else
      redirect_to users_path, :alert => "Unable to update user."
    end
  end

  def destroy
    puts "==== destroy"
    redirect_to :back, :alert => "Access denied."
    user = User.find(params[:id])
    user.destroy
    redirect_to users_path, :notice => "User deleted."
  end


  def admin_only
    unless current_user.admin? || current_user.super?
      redirect_to :back, :alert => "Access denied."
    end
  end

  def secure_params
    params.require(:user).permit(:role)
  end

end
