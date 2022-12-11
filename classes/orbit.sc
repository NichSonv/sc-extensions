OrbitAz : MultiOutUGen {

	*ar {
		arg numChans, in, cycles=10, time=3, dir='right', start=0, width=2, orientation=0.5, level=1;
		var sig, pan, direction;
		direction = case {dir=='right'}{1}{dir=='left'}{-1}{true}{"invalid dir argument!".error};
		pan = Env.circle([start, direction*(numChans-1*2*cycles+start)/numChans], time*cycles).kr;
		sig = PanAz.ar(numChans, in, pan, 1, width, orientation);
		sig = sig * level;
		^sig;
	}

	*kr {
		arg numChans, in, cycles=10, time=3, dir='right', start=0, width=2, orientation=0.5, level=1;
		var sig, pan, direction;
		direction = case {dir=='right'}{1}{dir=='left'}{-1}{true}{"invalid dir argument!".error};
		pan = Env.circle([start, direction*(numChans-1*2*cycles+start)/numChans], time*cycles).kr;
		sig = PanAz.kr(numChans, in, pan, 1, width, orientation);
		sig = sig * level;
		^sig;
	}

}