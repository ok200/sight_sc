// Grain Parameters
// 1. source file / wav file ... color
// 2. trate ... p1 -> ok
// 3. pitch ... p2 -> ok
// 4. pos ... p3 -> ok
// 5. trigger timing ?

// Other Parameters

// p1-p6 : [-1, 1]
// rgb : [0, 255]

(
s = Server.local;
s.sendMsg("/dumpOSC", 1);
)

(
// constants
var b0 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/loop002_mono.wav");
var b1 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/sine440.wav");
var b2 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/machi.wav");
var b3 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/suzume.wav");
var b4 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/plane.wav");
var b5 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/a11wlk01.wav");
var b6 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/checkout.wav");
var b7 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/comeon.wav");
var b8 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/gr.wav");
var b9 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/grass.wav");
var b10 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/harukaze.wav");
var b11 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/venus.wav");
var b12 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/violin.wav");
var b13 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/zanzo.wav");
var b14 = Buffer.read(s, "/Users/quolc/dev/jphack/sc/sounds/loop2.wav");
var sample_size = 1.2;
SynthDef(\synth0, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b0);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b0,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth1, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b1);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b1,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth2, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b2);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b2,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth3, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b3);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b3,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth4, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b4);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b4,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth5, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b5);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b5,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth6, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b6);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b6,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth7, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b7);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b7,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth8, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b8);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b8,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth9, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b9);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b9,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth10, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b10);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b10,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth12, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b12);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b12,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth13, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b13);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b13,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
SynthDef(\synth14, { | p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, pan=0, amp=0.5, gate=1 |
	var sig, env;
	var trate = 2 ** (p1*2 + 3); // p1*2+3 : [1,5]
	var dur = sample_size / trate;
	var pos = (p3+1)/2 * BufDur.kr(b14);

	sig = TGrains.ar(
		2,
		Impulse.ar(1.0/dur),
		b14,
		(2.0 ** p2),// * ((1.2) ** WhiteNoise.ar(0.5)), // turbulance
		pos, // centerPos
		dur,
		pan, amp, 2
	);
	env = EnvGen.kr(
		Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.8, releaseTime: 0.5, peakLevel: 1.0),
		gate, 1, doneAction: 2);
	sig = sig * env;
	Out.ar(0, sig);
}).add;
)

// register to receive this message
OSCresponder(s.addr,'/tr',{ arg time,responder,msg;
	[time,responder,msg].postln;
}).add;

//Env.adsr(attackTime: 0.1, decayTime: 0.2, sustainLevel: 0.5, releaseTime: 0.2, peakLevel: 1.0).test(1).plot;

s.sendMsg("/s_new", \synth4, 1004, 1, 1, \pan, -0.5, \amp, 2.0, \p1, 0.1, \p2, 0, \p3, 0);
s.sendMsg("/s_new", \synth7, 1003, 1, 1, \pan, 0.5, \amp, 2.0, \p1, 0.1, \p2, 0, \p3, 0);
s.sendMsg("/s_new", \synth10, 1002, 1, 1, \pan, 0, \amp, 2.0, \p1, -0.2, \p2, 0, \p3, 0.5);
s.sendMsg("/s_new", \synth12, 1001, 1, 1, \pan, 0, \amp, 1.0, \p1, 0, \p2, 0, \p3, 0);
s.sendMsg("/s_new", \synth14, 1000, 1, 1, \pan, 0, \amp, 4.0, \p1, -0.5, \p2, 0, \p3, 0);
s.sendMsg("/n_set", 1001, \gate, 0);
s.sendMsg("/n_free", 1000);

(
{HPF.ar(Saw.ar(WhiteNoise.kr(10, 200), 0.5, 0), 8000)}.play;
)
