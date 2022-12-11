// Simple play
+ SimpleNumber {

	play {
		arg out=0;
		{
			var sig, env;
			env = Env.perc(0.001, 0.2).kr(2);
			sig = SinOsc.ar(this, 0, env);
			sig = sig * 0.5!2;
			Out.ar(out, sig)
		}.play;
	}

	midiPlay {
		arg out=0;
		{
			var sig, env;
			env = Env.perc(0.001, 0.2).kr(2);
			sig = SinOsc.ar(this.midicps, 0, env);
			sig = sig * 0.5!2;
			Out.ar(out, sig)
		}.play;
	}

}