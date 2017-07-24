require "administrate/field/base"

class VendorIdField < Administrate::Field::Base
  def to_s
    data
  end
end
