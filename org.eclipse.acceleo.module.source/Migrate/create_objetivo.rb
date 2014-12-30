
class CreateObjetivo < ActiveRecord::Migration
  def self.up
    create_table :objetivo do |t|
        t.integer :aprendizaje_id
    end
  end

  def self.down
    drop_table :objetivo
  end
end
