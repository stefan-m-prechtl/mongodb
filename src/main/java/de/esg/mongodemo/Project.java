package de.esg.mongodemo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import com.google.common.base.MoreObjects;

@BsonDiscriminator
public class Project
{
	private ObjectId id;
	private String name;
	private String key;
	@BsonProperty(useDiscriminator = true)
	private Version version;
	public List<String> components;

	public Project()
	{
		this.components = Arrays.asList("Admin", "Export", "Import");
	}

	public Project(final String name, final String key, final Version version)
	{
		super();
		this.name = name;
		this.key = key;
		this.version = version;
	}

	public ObjectId getId()
	{
		return this.id;
	}

	public void setId(final ObjectId id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getKey()
	{
		return this.key;
	}

	public void setKey(final String key)
	{
		this.key = key;
	}

	public Version getVersion()
	{
		return this.version;
	}

	public void setVersion(final Version version)
	{
		this.version = version;
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
		final Project other = (Project) obj;

		return Objects.equals(this.id, other.id);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.id);
	}

	@Override
	public String toString()
	{
		//@formatter:off
		return MoreObjects.toStringHelper(this)
				.add("id", this.id.toHexString())
				.add("name", this.name)
				.add("key", this.name)
				.add("version", this.version.toString())
				.toString();
		//@formatter:on
	}

}
