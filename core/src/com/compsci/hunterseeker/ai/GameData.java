package com.compsci.hunterseeker.ai;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.items.Item;
import com.compsci.hunterseeker.util.Globals;

public class GameData {

	private DataSet data, aggregate;
	private long lastEntry, entryWait = 10;

	public GameData() {
		data = new DataSet(2, 4);
		aggregate = DataSet.createFromFile("aggregate_data.txt", 2, 4, ",",
				true);
	}

	public void addEntry(Item i, Item target) {
		if (System.currentTimeMillis() - lastEntry > entryWait) {
			Vector2 offset = new Vector2(i.pos).sub(target.pos);

			// float dx = (i.pos.x - target.pos.x) / Globals.APP_WIDTH;
			// float dy = (i.pos.y - target.pos.y) / Globals.APP_HEIGHT;
			// dx *= 10;
			// dy *= 10;
			float right = i.dir.x == 1 ? 1 : 0;
			float left = i.dir.x == -1 ? 1 : 0;
			float up = i.dir.y == 1 ? 1 : 0;
			float down = i.dir.y == -1 ? 1 : 0;
			if (right != 0 || left != 0 || up != 0 || down != 0) {
				// data.addRow(new DataSetRow(new double[] { dx, dy }, new
				// double[] {
				// left, right, down, up }));
				DataSetRow row = new DataSetRow(new double[] {
						(offset.len() / Math.sqrt(Globals.APP_WIDTH
								* Globals.APP_WIDTH + Globals.APP_HEIGHT
								* Globals.APP_HEIGHT)), offset.angle() / 360 },
						new double[] { left, right, down, up });
				data.addRow(row);
				aggregate.addRow(row);
			}
			/*
			 * if (Math.abs(dx) >= .1 && i.dir.x != 0) { float right = i.dir.x
			 * == 1 ? 1 : 0; float left = i.dir.x == -1 ? 1 : 0;
			 * xdata.addRow(new DataSetRow(new double[] { dx }, new double[] {
			 * left, right })); } if (Math.abs(dy) >= .1 && i.dir.y != 0) {
			 * float up = i.dir.y == 1 ? 1 : 0; float down = i.dir.y == -1 ? 1 :
			 * 0; ydata.addRow(new DataSetRow(new double[] { dy }, new double[]
			 * { down, up })); }
			 */
			lastEntry = System.currentTimeMillis();
		}
	}

	public void save() {
		data.save("xdata");
		data.saveAsTxt("xdata.txt", ",");
		aggregate.saveAsTxt("aggregate_data.txt", ",");
	}

	@Override
	public String toString() {
		return data.toString();
	}

	// public DataSet[] getDataSets() {
	// return new DataSet[] { data, ydata };
	// }
}
