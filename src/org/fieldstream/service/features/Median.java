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

// @author Andrew Raij

package org.fieldstream.service.features;

import java.util.Arrays;

import org.fieldstream.service.sensors.api.AbstractFeature;

public class Median extends AbstractFeature{

	public Median(int ID, boolean checkUpdate, float thresholdInput) {
		super(ID, checkUpdate, thresholdInput);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(int[] buffer, long[] timestamps, int sensor) {
		Arrays.sort(buffer);
		if (buffer.length == 0) {
			return Double.NaN;
		}
		else if (buffer.length % 2 == 1)
			return buffer[(buffer.length+1)/2-1];
		else
		{
			double lower = buffer[buffer.length/2-1];
			double upper = buffer[buffer.length/2];
			return (lower + upper) / 2.0;
		}
	}

}

