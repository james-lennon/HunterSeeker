package com.compsci.hunterseeker.ai;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import com.compsci.hunterseeker.items.Item;
import com.compsci.hunterseeker.util.Globals;

public class GameData {

	private DataSet xdata, ydata;
	private long lastEntry, entryWait = 10;

	public GameData() {
		xdata = new DataSet(1, 2);
		ydata = new DataSet(1, 2);
	}

	public void addEntry(Item i, Item target) {
		if (System.currentTimeMillis() - lastEntry > entryWait) {
			float dx = (i.pos.x - target.pos.x) / Globals.APP_WIDTH;
			float dy = (i.pos.y - target.pos.y) / Globals.APP_HEIGHT;
			// dx *= 10;
			// dy *= 10;
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

			lastEntry = System.currentTimeMillis();
		}
	}

	public void save() {
		xdata.save("xdata");
		xdata.saveAsTxt("xdata.txt", ",");
		ydata.save("ydata");
		ydata.saveAsTxt("ydata.txt", ",");
	}

	@Override
	public String toString() {
		return xdata.toString();
	}

	public DataSet[] getDataSets() {
		return new DataSet[] { xdata, ydata };
	}
}
