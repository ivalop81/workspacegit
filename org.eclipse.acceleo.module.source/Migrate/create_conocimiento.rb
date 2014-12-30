
class CreateConocimiento < ActiveRecord::Migration
  def self.up
    create_table :conocimiento do |t|
        t.integer :nivel_id
    end
  end

  def self.down
    drop_table :conocimiento
  end
end
