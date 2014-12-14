// http://yota.tehis.net/supako/

// defining function
(
var f1 = {|a|
	a * a;
};
f1.value(10);
)

// playing sound
(
var f1 = { SinOsc.ar * 0.1 };
var f2 = { Formant.ar * 0.1 };
f1.play;
f2.play;
)

// SinOsc.ar
(
{ SinOsc.ar(440, 0, 0.5, 0) }.play;
{ SinOsc.ar(freq: 440, phase: 0, mul: 0.1, add: 0) }.play; // same meaning
)

// XLine: Exponential line generator
(
{ SinOsc.ar(XLine.kr(440, 5000, 2), mul: 0.5)
	+ SinOsc.ar(XLine.kr(5000, 440, 2), mul: 0.5) }.play;
)

// defining synthesizer
(
SynthDef("hat", {| amp=0.1 |
	var sig;
	sig = WhiteNoise.ar;
	sig = sig * amp;
	Out.ar(0, sig); // output specification. 0=Left channel.
}).add;
)
Synth("hat"); // play

// adding high-pass filter
(
SynthDef("hat2", {| amp=0.1 |
	var sig;
	sig = WhiteNoise.ar;
	sig = HPF.ar(sig, 8000);
	sig = sig * amp;
	Out.ar(0, sig);
}).add;
)
Synth("hat2");

// adding envelope
(
SynthDef("hat3", {| amp=0.5 |
	var sig, env;
	// doneAction: 2 <- release resource after ending
	env = EnvGen.kr(Env.perc(attackTime: 0.01, releaseTime: 0.05, level: 1, curve: -3), 1, amp, doneAction: 2);
	sig = WhiteNoise.ar;
	sig = HPF.ar(sig, 8000);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
)
Synth("hat3"); // short sound

// plot envelope shape
Env.perc(attackTime: 0.01, releaseTime: 0.03, level: 1, curve: -3).plot;

// giving args to a synthesizer
(
SynthDef(\hat, {| amp=0.5, pan=0 |
	var sig, env;
	env = EnvGen.kr(Env.perc(attackTime: 0.01, releaseTime: 0.1), 1, amp, doneAction: 2);
	sig = SinOsc.ar;
//	sig = HPF.ar(sig, 8000);
	sig = sig * env;
	sig = Pan2.ar(sig, pan); // decide panning
	Out.ar(0, sig);
}).add;
)
Synth(\hat, [pan: -1]);
Synth(\hat, [pan: -0.5]);
Synth(\hat, [pan:  0]);
Synth(\hat, [pan:  0.5]);
Synth(\hat, [pan:  1]);

// create stream
p = Pseries(0, 2, 5).asStream;
p.next;

p = Pseq([6, 5, 1, 2.5, -100], inf).asStream; // infinit loop
p.next;
20.do { p.next.postln; }; // iteration

p = Pgeom(1, 2, inf).asStream;
p.next;

p = Pbrown(0, 1, 0.125, inf).asStream;
p.next;

// binding
(
SynthDef("hatX", {| amp=0.1, pan=0 |
	var sig, env;
	env = EnvGen.kr(Env.perc(0, 0.03), 1, amp, doneAction: 2);
	sig = WhiteNoise.ar;
	sig = HPF.ar(sig, 8000);
	sig = Pan2.ar(sig, pan, env);
	Out.ar(0, sig);
}).add;
)
// \dur: interval (reflecting Tempo)
~hatA = Pbind(\instrument, "hatX", \dur, 0.5, \amp, Pseq([0.4, 0.2, 0.3, 0.2], inf))
~hatA.play;

// melody
(
SynthDef("sine", {| amp=0.5, pitch=0 |
	var sig, env;
	env = EnvGen.kr(Env.perc(0, 0.25), 1, amp, doneAction: 2);
	sig = SinOsc.ar(440 * (2 **(1.0/12 * pitch)), 0, 1);
	Out.ar(0, sig);
}).add;
)
(
var mel = Pbind(\instrument, "sine", \dur, 1, \pitch, Pseq([0, 2, 4, 5, 4, 2], inf));
mel.play;
)

// snare
(
SynthDef(\snr, {| amp=0.1 |
	var sig, env, snr, mem;
	env = EnvGen.kr(Env.perc(0, 0.05), 1, amp, doneAction: 2);
	snr = WhiteNoise.ar; // snare
	mem = FSinOsc.ar(200); // membrane
	sig = LPF.ar(snr + mem, 12000);
	sig = Pan2.ar(sig, 0, env);
	Out.ar(0, sig);
}).add;
)
Synth(\snr, [amp: 0.5]);

// kick
(
SynthDef(\kik, {| amp=0.5, sustain=1, freq=30 |
	var sig, frqEnv, ampEnv;
	frqEnv = EnvGen.kr(Env.perc, 1, freq*10, freq, 0.023);
	ampEnv = EnvGen.kr(Env.linen(0.01, 0.1, 0.3, 1, [-5,1,-4]), 1, amp, 0, sustain, 2);
	sig = SinOsc.ar(frqEnv, 0, ampEnv);
	sig = Pan2.ar(sig, 0);
	Out.ar(0, sig);
}).add;
)
Synth(\kik, [freq: 200]);
(
var mel = Pbind(\instrument, \kik, \dur, 0.25, \freq, Pseq([200, 440, 220, 50], inf));
mel.play;
)

{ SinOsc.ar([400, 405], mul: 0.1) }.play;

// saw wave
(
SynthDef(\bss, {| gate=1, amp=0.1, sustain=1, freq=440 |
	var sig, env;
	env = EnvGen.kr(Env.adsr, gate, amp, 0, sustain, 2);
	sig = LFSaw.ar(freq); // saw wave
	sig = RLPF.ar(sig, 1000);
	sig = Pan2.ar(sig, 0, env);
	Out.ar(0, sig);
}).add;
)
Synth(\bss);

Env.adsr.plot;