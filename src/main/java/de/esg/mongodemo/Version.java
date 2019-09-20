package de.esg.mongodemo;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Version
{
	private int number;
	private String state;
	private String description;

	public Version()
	{

	}

	public Version(final int number, final String state, final String description)
	{
		super();
		this.number = number;
		this.state = state;
		this.description = description;
	}

	public int getNumber()
	{
		return this.number;
	}

	public void setNumber(final int number)
	{
		this.number = number;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		final Version other = (Version) obj;

		return Objects.equals(this.number, other.number);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.number);
	}

	@Override
	public String toString()
	{
	//@formatter:off
	return MoreObjects.toStringHelper(this)
			.add("number", this.number)
			.add("state", this.state)
			.add("desc", this.description)
			.toString();
	//@formatter:on
	}
}
