package zuul.course;

/**
 * @author Mathieu Molinengo
 * @version 20/11/2014
 */
public class LectureItem extends Item {
	private String bundleKey;
	
	public LectureItem(){
		super();
	}

	public LectureItem(String module, int number) {
		super(module, number);
		bundleKey="";
	}
	
	public LectureItem(String module, int number, String key) {
		super(module, number);
		bundleKey=key;
	}

	@Override
	public boolean equals(Object object){
		boolean equality = false;
		if(object instanceof LectureItem)
		{
			if(this.module.equals(((LectureItem) object).getModule()))
			{
				if(this.number==((LectureItem) object).getNumber())
				{
					equality=true;
				}
			}
		}
		return equality;
	}
	
	
	/**
	 * @return the bundleKey
	 */
	public String getBundleKey() {
		return bundleKey;
	}

	/**
	 * @param bundleKey the bundleKey to set
	 */
	public void setBundleKey(String bundleKey) {
		this.bundleKey = bundleKey;
	}
}
