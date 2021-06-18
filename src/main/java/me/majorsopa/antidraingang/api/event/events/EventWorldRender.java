package me.majorsopa.antidraingang.api.event.events;

import me.majorsopa.antidraingang.api.event.Event;

public class EventWorldRender extends Event {

	public final float partialTicks;

	public EventWorldRender(float partialTicks) {
		this.partialTicks = partialTicks;
	}
}