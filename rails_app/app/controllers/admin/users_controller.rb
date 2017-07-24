module Admin
#
# override in routes.rb to call this
#   namespace :admin do
#        resources :users
#        root to: "users#index"
#    end
#
# TODO : refactor to change from user, which is confusing
#
    class UsersController < Admin::ApplicationController
        before_action :admin_only

        # To customize the behavior of this controller,
        # simply overwrite any of the RESTful actions. For example:
        #
        class VendorSearch < Administrate::Search
            def run(vendor_id)
                resource_class.where("(#{query}) and vendor_id = ?", *search_terms, vendor_id)
            end
        end

        def index
            puts "===== index admin user"
            # search bar data
            search_term = params[:search].to_s.strip

            # local, over-ridden class to include vendor id search
            resources = VendorSearch.new(resource_resolver, search_term).run(current_user.vendor_id)

            resources = order.apply(resources)
            resources = resources.page(params[:page]).per(records_per_page)
            page = Administrate::Page::Collection.new(dashboard, order: order)

            render locals: {
                resources: resources,
                search_term: search_term,
                page: page,
            }
        end

        def edit
            puts "====== edit vendor"
            if vendor_match?
                render locals: {
                    page: Administrate::Page::Form.new(dashboard, requested_resource),
                }
            else
                redirect_to :back, :alert => "Access denied."
            end
        end

        def update
            puts "========== update"

            # if no password entered, don't update password
            if resource_params["password"].empty?
                rc = requested_resource.update_without_password(resource_params)
            else
                rc = requested_resource.update(resource_params)
            end

            if rc
                redirect_to(
                [namespace, requested_resource],
                notice: translate_with_resource("update.success"),
                )
            else
                render :edit, locals: {
                    page: Administrate::Page::Form.new(dashboard, requested_resource),
                }
            end
        end


        def destroy
            if vendor_match?
                requested_resource.destroy
                flash[:notice] = translate_with_resource("destroy.success")
                redirect_to action: :index
            else
                redirect_to :back, :alert => "Access denied."
            end
        end

        def authenticate_admin
            current_user && current_user.admin?
        end

        private

        def  vendor_match?
            requested_resource.vendor_id == current_user.vendor_id
        end

        # Define a custom finder by overriding the `find_resource` method:
        #def find_resource(param)
        #User.find_by!(slug: param)
        #end

        # See https://administrate-docs.herokuapp.com/customizing_controller_actions
        # for more information
    end
end
