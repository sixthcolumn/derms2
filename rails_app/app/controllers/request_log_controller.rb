class RequestLogController < ApplicationController

  layout "request_log"

  def index
    @logs = RequestLog.order(request_log_id: :desc)
  end

end
