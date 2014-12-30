
class CreatePreferencia < ActiveRecord::Migration
  def self.up
    create_table :preferencia do |t|
        t.integer :fuente_id
        t.integer :imagen_id
        t.integer :lenguaje_id
    end
  end

  def self.down
    drop_table :preferencia
  end
end
