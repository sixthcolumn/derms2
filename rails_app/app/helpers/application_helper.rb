module ApplicationHelper

require 'rexml/document'

  def admin_only
    unless current_user.admin? or current_user.super?
      redirect_to :back, :alert => "Access denied."
    end
  end

  def title(title = nil)
    if title.present?
      content_for :title, title
    else
      content_for?(:title) ? APP_CONFIG['default_title'] + ' | ' + content_for(:title) : APP_CONFIG['default_title']
    end
  end

  def formatXML(message)
    response = "";

    doc = REXML::Document.new(message)
    formatter = REXML::Formatters::Pretty.new
    formatter.compact = true

    formatter.write(doc, response)
    return response
  end
end
