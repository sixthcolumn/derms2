# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20160508163842) do

  create_table "message", primary_key: "message_id", force: :cascade do |t|
    t.string  "name",                limit: 80,                         null: false
    t.integer "package_group_id",    limit: 4,                          null: false
    t.boolean "request_flag",                           default: false, null: false
    t.text    "default_message_txt", limit: 4294967295
  end

  add_index "message", ["name"], name: "message_name", unique: true, using: :btree
  add_index "message", ["package_group_id"], name: "message_package_group_id", using: :btree

  create_table "message_log", primary_key: "message_log_id", force: :cascade do |t|
    t.text     "address",      limit: 4294967295
    t.string   "contentType",  limit: 255
    t.datetime "create_date"
    t.string   "data",         limit: 255
    t.string   "encoding",     limit: 255
    t.text     "faultCode",    limit: 4294967295
    t.text     "header",       limit: 4294967295
    t.text     "httpMethod",   limit: 4294967295
    t.string   "message",      limit: 255
    t.string   "messageId",    limit: 255
    t.string   "operation",    limit: 255
    t.text     "payload",      limit: 4294967295
    t.text     "responseCode", limit: 4294967295
    t.string   "resultCode",   limit: 255
    t.integer  "message_id",   limit: 4
    t.string   "stage",        limit: 50
  end

  add_index "message_log", ["message_id"], name: "INTERFACE_ID", using: :btree

  create_table "package", primary_key: "package_id", force: :cascade do |t|
    t.string "name", limit: 40, null: false
  end

  create_table "package_group", primary_key: "package_group_id", force: :cascade do |t|
    t.string  "name",       limit: 40, null: false
    t.integer "package_id", limit: 4,  null: false
  end

  add_index "package_group", ["package_id"], name: "package_group_package_id", using: :btree

  create_table "test_seq_step", primary_key: "test_seq_step_id", force: :cascade do |t|
    t.integer "test_sequence_id", limit: 4,                   null: false
    t.integer "in_message_id",    limit: 4,                   null: false
    t.string  "esb_url",          limit: 512
    t.string  "harness_url",      limit: 512
    t.boolean "swap_corrid_flag",             default: false, null: false
    t.integer "next_step_id",     limit: 4,   default: 0
  end

  add_index "test_seq_step", ["in_message_id"], name: "test_steps_in_message_id", using: :btree
  add_index "test_seq_step", ["next_step_id"], name: "test_steps_next_step_id", using: :btree
  add_index "test_seq_step", ["test_sequence_id"], name: "test_seq_step_test_seq", using: :btree

  create_table "test_sequence", primary_key: "test_sequence_id", force: :cascade do |t|
    t.string  "name",        limit: 40,                          null: false
    t.string  "description", limit: 1024
    t.string  "type",        limit: 12,   default: "standalone", null: false
    t.integer "user_id",     limit: 4
  end

  add_index "test_sequence", ["user_id"], name: "fk_rails_eaa7c84af2", using: :btree

  create_table "users", force: :cascade do |t|
    t.string   "email",                  limit: 255, default: "", null: false
    t.string   "encrypted_password",     limit: 255, default: "", null: false
    t.string   "reset_password_token",   limit: 255
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          limit: 4,   default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.string   "current_sign_in_ip",     limit: 255
    t.string   "last_sign_in_ip",        limit: 255
    t.datetime "created_at",                                      null: false
    t.datetime "updated_at",                                      null: false
    t.string   "name",                   limit: 255
    t.integer  "role",                   limit: 4
    t.integer  "vendor_id",              limit: 4
  end

  add_index "users", ["email"], name: "index_users_on_email", unique: true, using: :btree
  add_index "users", ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true, using: :btree
  add_index "users", ["vendor_id"], name: "fk_rails_0d9fb09c73", using: :btree

  create_table "vendor", primary_key: "vendor_id", force: :cascade do |t|
    t.string   "name",       limit: 40, null: false
    t.datetime "created_at",            null: false
  end

  add_index "vendor", ["name"], name: "vendor_name", unique: true, using: :btree

  create_table "vendor_packages", primary_key: "vendor_packages_id", force: :cascade do |t|
    t.integer "vendor_id",  limit: 4, null: false
    t.integer "package_id", limit: 4, null: false
  end

  add_index "vendor_packages", ["package_id"], name: "vendor_package_package_id", using: :btree
  add_index "vendor_packages", ["vendor_id"], name: "vendor_package_vendor_id", using: :btree

  create_table "vendor_request_message", primary_key: "vendor_request_message_id", force: :cascade do |t|
    t.integer "vendor_id",   limit: 4,          null: false
    t.integer "message_id",  limit: 4,          null: false
    t.text    "message_txt", limit: 4294967295, null: false
    t.string  "sent_to_url", limit: 500
    t.string  "description", limit: 512
  end

  add_index "vendor_request_message", ["message_id"], name: "vendor_request_message_message_id", using: :btree
  add_index "vendor_request_message", ["vendor_id"], name: "vendor_request_message_vendor_id", using: :btree

  create_table "vendor_seq_step_logging", primary_key: "vendor_seq_step_logging_id", force: :cascade do |t|
    t.integer  "vendor_id",                limit: 4,    null: false
    t.integer  "vendor_test_seq_steps_id", limit: 4,    null: false
    t.string   "in_mess_id",               limit: 255
    t.string   "out_mess_id",              limit: 255
    t.string   "in_reply_url",             limit: 1024
    t.datetime "tstamp",                                null: false
  end

  add_index "vendor_seq_step_logging", ["vendor_id"], name: "vend_seq_logging_vendor_id", using: :btree
  add_index "vendor_seq_step_logging", ["vendor_test_seq_steps_id"], name: "vend_seq_logging_test_seq_step_id", using: :btree

  create_table "vendor_test_seq_steps", primary_key: "vendor_test_seq_steps_id", force: :cascade do |t|
    t.integer "vendor_test_sequences_id", limit: 4,    null: false
    t.integer "test_seq_step_id",         limit: 4,    null: false
    t.string  "out_url",                  limit: 1024, null: false
  end

  add_index "vendor_test_seq_steps", ["test_seq_step_id"], name: "vendor_test_seq_steps_test_seq_step_id", using: :btree
  add_index "vendor_test_seq_steps", ["vendor_test_sequences_id"], name: "vendor_test_seq_steps_vendor_sequence_id", using: :btree

  create_table "vendor_test_sequences", primary_key: "vendor_test_sequences_id", force: :cascade do |t|
    t.integer "vendor_id",        limit: 4,                 null: false
    t.integer "test_sequence_id", limit: 4,                 null: false
    t.boolean "asynch_flag",                default: false, null: false
  end

  add_index "vendor_test_sequences", ["test_sequence_id"], name: "vendor_test_seq_test_seq_id", using: :btree
  add_index "vendor_test_sequences", ["vendor_id"], name: "vendor_test_seq_vendor_id", using: :btree

  add_foreign_key "message", "package_group", primary_key: "package_group_id", name: "message_package_group_id"
  add_foreign_key "message_log", "message", primary_key: "message_id", name: "message_log_message_id"
  add_foreign_key "package_group", "package", primary_key: "package_id", name: "package_group_package_id"
  add_foreign_key "test_seq_step", "message", column: "in_message_id", primary_key: "message_id", name: "test_steps_in_message_id"
  add_foreign_key "test_seq_step", "test_seq_step", column: "next_step_id", primary_key: "test_seq_step_id", name: "test_steps_next_step_id"
  add_foreign_key "test_seq_step", "test_sequence", primary_key: "test_sequence_id", name: "test_seq_step_test_seq"
  add_foreign_key "test_sequence", "users"
  add_foreign_key "vendor_packages", "package", primary_key: "package_id", name: "vendor_package_package_id"
  add_foreign_key "vendor_packages", "vendor", primary_key: "vendor_id", name: "vendor_package_vendor_id"
  add_foreign_key "vendor_request_message", "message", primary_key: "message_id", name: "vendor_request_message_message_id"
  add_foreign_key "vendor_request_message", "vendor", primary_key: "vendor_id", name: "vendor_request_message_vendor_id"
  add_foreign_key "vendor_seq_step_logging", "vendor", primary_key: "vendor_id", name: "vend_seq_logging_vendor_id"
  add_foreign_key "vendor_seq_step_logging", "vendor_test_seq_steps", column: "vendor_test_seq_steps_id", primary_key: "vendor_test_seq_steps_id", name: "vend_seq_logging_test_seq_step_id"
  add_foreign_key "vendor_test_seq_steps", "test_seq_step", primary_key: "test_seq_step_id", name: "vendor_test_seq_steps_test_seq_step_id"
  add_foreign_key "vendor_test_seq_steps", "vendor_test_sequences", column: "vendor_test_sequences_id", primary_key: "vendor_test_sequences_id", name: "vendor_test_seq_steps_vendor_sequence_id"
  add_foreign_key "vendor_test_sequences", "test_sequence", primary_key: "test_sequence_id", name: "vendor_test_seq_test_seq_id"
  add_foreign_key "vendor_test_sequences", "vendor", primary_key: "vendor_id", name: "vendor_test_seq_vendor_id"
end
