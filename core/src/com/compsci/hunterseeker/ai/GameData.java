package com.compsci.hunterseeker.ai;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

import com.compsci.hunterseeker.items.Item;
import com.compsci.hunterseeker.util.Globals;

public class GameData {

	private DataSet data;

	public GameData() {
		data = new DataSet(2, 2);
	}

	public void addEntry(Item i, Item target) {
		float dx = (i.pos.x - target.pos.x) / Globals.APP_WIDTH;
		float dy = (i.pos.y - target.pos.y) / Globals.APP_HEIGHT;
		data.addRow(new DataSetRow(new double[] { dx, dy }, new double[] {
				i.dir.x, i.dir.y }));
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
