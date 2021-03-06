﻿//Copyright (c) 2010, University of Memphis
//All rights reserved.
//
//Redistribution and use in source and binary forms, with or without modification, are permitted provided 
//that the following conditions are met:
//
//    * Redistributions of source code must retain the above copyright notice, this list of conditions and 
//      the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions 
//      and the following disclaimer in the documentation and/or other materials provided with the 
//      distribution.
//    * Neither the names of the University of Memphis nor the names of its contributors may be used to 
//      endorse or promote products derived from this software without specific prior written permission.
//
//THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED 
//WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
//PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR 
//ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
//TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
//HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
//NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
//POSSIBILITY OF SUCH DAMAGE.
//

// @author Mahbub Rahman
package org.fieldstream.service.features;
import java.util.Arrays;

import org.fieldstream.service.features.Percentile;
import org.fieldstream.service.sensors.api.AbstractFeature;

import android.util.Log;

public class  QuartileDeviation extends AbstractFeature{
	public QuartileDeviation(final int ID, final boolean checkUpdate, final float thresholdInput) {
		super(ID, checkUpdate, thresholdInput);
	}
	public double calculate(final int[] buffer, final long[] timestamps, final int sensor) {
		return evaluate(buffer);
	}

	public static double evaluate(final int[] values) {		
		double third, first;
		third=Percentile.evaluate(values, 75.0F);
		first=Percentile.evaluate(values, 25.0F);
		return (third-first)/2.0;
		//		String ripData="";
//		for(int i=0;i<values.length;i++)
//		{
//			ripData+=values[i]+",";
//		}
//		Log.d("percentile","percentile raw="+ripData);
		
/*		if ((p > 100) || (p <= 0)) {
			throw new IllegalArgumentException("invalid quantile value: " + p);
		}
		double n = (double) values.length;
		if (n == 0) {
			return Double.NaN;
		}
		if (n == 1) {
			return values[0]; // always return single value for n = 1
		}
		double pos = p * (n + 1) / 100;
		double fpos = Math.floor(pos);
		int intPos = (int) fpos;
		double dif = pos - fpos;
		int[] sorted = new int[values.length];
		System.arraycopy(values, 0, sorted, 0, values.length);
		Arrays.sort(sorted);

		if (pos < 1) {
			return sorted[0];
		}
		if (pos >= n) {
			return sorted[values.length - 1];
		}
		double lower = sorted[intPos - 1];
		double upper = sorted[intPos];
		return lower + dif * (upper - lower);
	*/
	}
}
