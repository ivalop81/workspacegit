
class CreateInteres < ActiveRecord::Migration
  def self.up
    create_table :interes do |t|
        t.integer :secuencia_id
    end
  end

  def self.down
    drop_table :interes
  end
end
