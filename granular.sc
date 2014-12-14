// Load an audio file
s.sendMsg(\b_allocRead, 10,
//	"/Applications/SuperCollider/SuperCollider.app/Contents/Resources/sounds/a11wlk01.wav");
	"/Applications/SuperCollider/SuperCollider.app/Contents/Resources/sounds/a11wlk01-44_1.aiff");
//	"/Users/quolc/dev/jphack/sc/sounds/loop002.wav");

(
{
var b = 10, trate, dur, pan;
trate = MouseY.kr(2,24,1); // n倍速
dur = 1.2 / trate; // 再生時間
pan = WhiteNoise.kr(0.6);
TGrains.ar(
	2, // number of out-channels
	Impulse.ar(trate),
	b, // buffer number
	(1.2 ** WhiteNoise.ar(1).round(1)),
//	1.0,
	MouseX.kr(0,BufDur.kr(b)),
	dur,
	-1.00, 0.5, 2
);
}.play;
)

(
{
var b = 10, trate, dur;
trate = MouseY.kr(2,24,1); // n倍速
dur = 0.2 / trate; // 再生時間
GrainSin.ar(
	2, // number of out-channels
	Impulse.ar(1.0/dur),
	dur,
	SinOsc.ar(100, 0, 100, 440),
	0,
	-1,
	512, 0.5, 0
);
}.play;
)


(
{
var b = 10, trate, dur;
trate = MouseY.kr(2,24,1); // n倍速
dur = 0.5 / trate; // 再生時間
GrainIn.ar(
	2, // number of out-channels
	Impulse.ar(1.0/dur),
	dur,
		Saw.ar(SinOsc.kr(5, 0, 100, 440) * WhiteNoise.kr(1, 1)),
	0,
	-1,
	512, 0.5, 0
);
}.play;
)

