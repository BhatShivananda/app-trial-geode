package org.springframework.data.gemfire;

import java.util.Collection;
import java.util.Map;

import com.gemstone.gemfire.GemFireException;
import com.gemstone.gemfire.cache.Region;

public class GemfireTemplate {

	
	@SuppressWarnings("rawtypes")
	private Region region;

	public GemfireTemplate() {
	}

	public <K, V> GemfireTemplate(Region<K, V> region) {
		this.region = region;
	}

	@SuppressWarnings("unchecked")
	public <K, V> Region<K, V> getRegion() {
		return region;
	}
	
	public <K, V> void create(final K key, final V value) {
		try {
			getRegion().create(key, value);
		}
		catch (GemFireException e) {
			throw e;
		}
	}

	public <K, V> V get(final K key) {
		try {
			return this.<K, V>getRegion().get(key);
		}
		catch (GemFireException e) {
			throw e;
		}
	}

	public <K, V> Map<K, V> getAll(final Collection<?> keys) {
		try {
			return this.<K, V>getRegion().getAll(keys);
		}
		catch (GemFireException e) {
			throw e;
		}
	}

	public <K, V> V put(final K key, final V value) {
		try {
			return this.<K, V>getRegion().put(key, value);
		}
		catch (GemFireException e) {
			throw e;
		}
	}


	public <K, V> V remove(final K key) {
		try {
			return this.<K, V>getRegion().remove(key);
		}
		catch (GemFireException e) {
			throw e;
		}
	}

	public <K, V> V replace(final K key, final V value) {
		try {
			return this.<K, V>getRegion().replace(key, value);
		}
		catch (GemFireException e) {
			throw e;
		}
	}

	public <K, V> boolean replace(final K key, final V oldValue, final V newValue) {
		try {
			return this.<K, V>getRegion().replace(key, oldValue, newValue);
		}
		catch (GemFireException e) {
			throw e;
		}
	}
}
