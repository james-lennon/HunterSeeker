package com.compsci.hunterseeker.ai;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import com.compsci.hunterseeker.items.Item;
import com.compsci.hunterseeker.util.Globals;

public class GameData {

	private DataSet data, ydata;
	private long lastEntry, entryWait = 10;

	public GameData() {
		data = new DataSet(2, 4);
		ydata = new DataSet(1, 2);
	}

	public void addEntry(Item i, Item target) {
		if (System.currentTimeMillis() - lastEntry > entryWait) {
			float dx = (i.pos.x - target.pos.x) / Globals.APP_WIDTH;
			float dy = (i.pos.y - target.pos.y) / Globals.APP_HEIGHT;
			// dx *= 10;
			// dy *= 10;
			float right = i.dir.x == 1 ? 1 : 0;
			float left = i.dir.x == -1 ? 1 : 0;
			float up = i.dir.y == 1 ? 1 : 0;
			float down = i.dir.y == -1 ? 1 : 0;
			data.addRow(new DataSetRow(new double[] { dx, dy }, new double[] {
					left, right, down, up }));
			/*
			if (Math.abs(dx) >= .1 && i.dir.x != 0) {
				float right = i.dir.x == 1 ? 1 : 0;
				float left = i.dir.x == -1 ? 1 : 0;
				xdata.addRow(new DataSetRow(new double[] { dx }, new double[] {
						left, right }));
			}
			if (Math.abs(dy) >= .1 && i.dir.y != 0) {
				float up = i.dir.y == 1 ? 1 : 0;
				float down = i.dir.y == -1 ? 1 : 0;
				ydata.addRow(new DataSetRow(new double[] { dy },
						new double[] { down, up }));
			}
			*/
			lastEntry = System.currentTimeMillis();
		}
	}

	public void save() {
		data.save("xdata");
		data.saveAsTxt("xdata.txt", ",");
		ydata.save("ydata");
		ydata.saveAsTxt("ydata.txt", ",");
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public DataSet[] getDataSets() {
		return new DataSet[] { data, ydata };
	}
}
