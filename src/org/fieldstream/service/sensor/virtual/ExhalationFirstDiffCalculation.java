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
//    * Neither the name of the University of Memphis nor the names of its contributors may be used to 
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


//@author Amin Ahsan Ali
//@author Mahbub Rahman


package org.fieldstream.service.sensor.virtual;
import java.util.ArrayList;

/************************
 * 
 * @author mahbub
 *
 */

public class ExhalationFirstDiffCalculation {

	
	public  int[] calculate(int[] databuffer, long[] timestamps) {
		int exhalations[]=getExhalationsFirstDiff(databuffer);
		return exhalations;
	}
	/**
	 * calculates first difference of exhalations from the exhalation durations array
	 * @param data arrays of exhalation
	 * @return arrays of first difference from exhalation duration
	 */
	public int[] getExhalationsFirstDiff(int[] data)			//window size will be 4*(number of real peaks) is typically 4*5 because we are gonna consider 5 real peaks at a time
	{
		int length=data.length;
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		
//		for(;i<temp;i+=4)
//		{
//			//check the starting whether it starts from valley or not. It should be valley
//			if((i==0) && (data[i+1]>data[i+3]))
//				continue;						//it escaping if first member is a peak. in that case we can not find the inspiration. inspiration always starts from a valley
//			
//			
//			//check last element whether it is valley or peak. it should be valley
//			if((i==0)&&(data[length-1]>data[length-3]))		//at the beginning the stopping condition is changed
//				temp=length-2;
//			
//			if(i+4<length)
//			{
//				valleyIndex=data[i+4];
//				peakIndex=data[i+2];
//				list.add(new Integer(Math.abs(valleyIndex-peakIndex)));
//			}
//		}
		if(length>1)
		{
			int value1=data[0];
			for(int t=1;t<length;t++)
			{
				int value2=data[t];
				list.add(new Integer(Math.abs(value1-value2)));
				value1=value2;
			}
		}
		//converting the ArrayList to array
		int exhalationFirstDiff[]=new int[list.size()];
		for(int j=0;j<list.size();j++)
		{
			exhalationFirstDiff[j]=list.get(j).intValue();
		}
		return exhalationFirstDiff;
	}
}
