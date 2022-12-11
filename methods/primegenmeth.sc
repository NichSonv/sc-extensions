// Prime number generator, by Nicholas Sonvezzo
+ SequenceableCollection {

	*prime {
		arg size, start = 1;
		var seq, count = start;
		seq = this.fill(size, nil);
		seq = seq.collect{
			arg n;
			var prime = false;
			while{prime.not} {
				if(count.isPrime) {prime=true; n=count} {count=count+1};
			};
			count = count + 1;
		};
		seq = seq-1; // correction. Don't know why the seq returns plus 1 from what it should...
		^seq;
	}

}