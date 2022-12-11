VerbEF {

	*ar {
		arg in, dec=3.5, mix=0.08, lpf1=2e3, lpf2=6e3, predel=0.025, mul=1, add=0;
		var dry, wet, sig;
		dry = in;
		wet = in;
		wet = DelayN.ar(wet, 0.5, predel.clip(1e-4, 0.5));
		wet = 16.collect{
			var temp;
			temp = CombL.ar(
				wet,
				0.1,
				LFNoise1.kr({ExpRand(0.02, 0.04)}!2).exprange(0.02, 0.099),
				dec
			);
			temp = LPF.ar(temp, lpf1)
		}.sum * 0.25;
		8.do{
			wet = AllpassL.ar(
				wet,
				0.1,
				LFNoise1.kr({ExpRand(0.02, 0.04)}!2).exprange(0.02, 0.099),
				dec
			);
		};
		wet = LeakDC.ar(wet);
		wet = LPF.ar(wet, lpf2, 0.5);
		sig = dry.blend(wet, mix);
		sig = sig * mul + add;
		^sig;
	}

}